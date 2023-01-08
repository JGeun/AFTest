package com.jgeun.aftest.feature.broad_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jgeun.aftest.common_ui.result.UiState
import com.jgeun.aftest.common_ui.vo.BroadInfoViewArgument
import com.jgeun.aftest.domain.usecase.GetBroadCategoriesUseCase
import com.jgeun.aftest.domain.usecase.GetCategoryBroadsUseCase
import com.jgeun.aftest.domain.usecase.GetNextBroadsUseCase
import com.jgeun.aftest.domain.vo.BroadListVO
import com.jgeun.aftest.domain.vo.CategoryBroadsVO
import com.jgeun.aftest.domain.vo.CategoryVO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BroadViewModel @Inject constructor(
    private val getNextBroadsUseCase: GetNextBroadsUseCase,
    private val getCategoryBroadsUseCase: GetCategoryBroadsUseCase,
    private val getBroadCategoryListUseCase: GetBroadCategoriesUseCase
) : ViewModel() {

    // 카테고리관련 변수
    private val _categories = MutableStateFlow(emptyList<CategoryVO>())
    val categories: StateFlow<List<CategoryVO>> get() = _categories

    // 카테고리별 영상 관련 변수
    private val categoryBroadsDataList = mutableListOf<CategoryBroadsVO>()
    private val _categoryBroads: MutableStateFlow<UiState<List<CategoryBroadsVO>>> =
        MutableStateFlow(UiState.Loading)
    val categoryBroads: StateFlow<UiState<List<CategoryBroadsVO>>>
        get() = _categoryBroads

    init {
        viewModelScope.launch(Dispatchers.IO) {
            getBroadCategoryListUseCase().collectLatest { categories ->

                /**
                 * 비주류 카테고리의 경우 리스트가 아예 나오지 않는 경우가 발생
                 * 따라서 최상단 5개 카테고리는 영상이 항상 나오는 것을 확인했기에 5개까지 자르는 걸로 진행
                 */
                val randomCategories = categories.subList(0, 5)
                _categories.value = randomCategories

                fetchCategoryBroads()
            }
        }
    }

    private fun CoroutineScope.fetchCategoryBroads() {

        initCategoryBroads() // 첫 초기화시 카테고리별 사이즈만큼 EMPTY 객체 할당

        var count = 0
        _categories.value.forEachIndexed { i, categoryVO ->

            // 코루틴 병렬처리를 통한 시간속도 향상 - 병렬처리 X: 평균 295.66ms / 병렬처리: 평균 154.5ms
            async {
                getCategoryBroadsUseCase(categoryVO.cateNo).collectLatest {
                    categoryBroadsDataList[i] =
                        CategoryBroadsVO(
                            categoryVO.cateNo,
                            categoryVO.cateName,
                            it
                        )
                    count += 1

                    if (count == _categories.value.size) {
                        _categoryBroads.value = UiState.Success(categoryBroadsDataList)
                    }
                }
            }
        }
    }

    private fun initCategoryBroads() {
        _categories.value.indices.forEach { _ ->
            categoryBroadsDataList.add(CategoryBroadsVO("", "", BroadListVO.EMPTY))
        }
    }

    // 다음 페이지 영상 가져오기
    fun fetchNextBroadList(pos: Int) {
        viewModelScope.launch {
            _categoryBroads.value = UiState.Loading

            getNextBroadsUseCase(categoryBroadsDataList[pos]).collectLatest {

                // 해당 카테고리 위치에 데이터 저장
                categoryBroadsDataList[pos] = it
                _categoryBroads.value = UiState.Success(categoryBroadsDataList)
            }
        }
    }

    // 해당 번호의 broad 정보 반환
    fun getBroadInfo(categoryPos: Int, broadPos: Int): BroadInfoViewArgument {
        val broad = categoryBroadsDataList[categoryPos].broadList.broad[broadPos]
        return BroadInfoViewArgument(
            title = broad.broadTitle,
            thumb = broad.broadThumb,
            profileImg = broad.profileImg,
            nickname = broad.userNick,
            totalViewCnt = broad.totalViewCnt
        )
    }
}