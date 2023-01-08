package com.jgeun.aftest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.jgeun.aftest.common_ui.util.ActivityUtil
import com.jgeun.aftest.common_ui.vo.BroadInfoViewArgument
import com.jgeun.aftest.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * 하위 모듈들이 접근할 수 없는 코드를 [ActivityUtil]을 통해 하위 모듈에 제공합니다.
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity(), ActivityUtil {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        supportActionBar?.hide()

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
    }

    override fun navigateToBroadInfo(broadInfo: BroadInfoViewArgument) {
        val bundle = bundleOf("broadInfo" to broadInfo)
        navController.navigate(R.id.action, bundle)
    }
}