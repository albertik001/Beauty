package com.geektech.beauty.presentation.ui.fragments.main.home.salon

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.beauty.R
import com.geektech.beauty.core.base.BaseFragment
import com.geektech.beauty.databinding.FragmentSalonBinding
import com.geektech.beauty.presentation.models.PromotionsUI
import com.geektech.beauty.presentation.ui.adapters.ButtonServicesAdapter
import com.geektech.beauty.presentation.ui.adapters.PromotionsPagerAdapter
import com.geektech.beauty.presentation.ui.adapters.TopSpecialistAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SalonFragment : BaseFragment<FragmentSalonBinding, SalonViewModel>(R.layout.fragment_salon) {
    override val binding by viewBinding(FragmentSalonBinding::bind)
    override val viewModel by viewModels<SalonViewModel>()
    private val buttonServicesAdapter = ButtonServicesAdapter()
    private val topSpecialistAdapter = TopSpecialistAdapter()

    override fun initialize() {
        setPromotionsPager(viewModel.getPromotionBanners())
        setSalonInformation()
        setButtonServices()
        setTopSpecialist()
    }

    private fun setTopSpecialist() {
        binding.recyclerViewTopSpecialist.adapter = topSpecialistAdapter
        topSpecialistAdapter.submitList(viewModel.getTopSpecialist())
    }

    private fun setButtonServices() {
        binding.recyclerViewButtonServices.adapter = buttonServicesAdapter
        buttonServicesAdapter.submitList(viewModel.getButtonServices())
    }

    private fun setSalonInformation() {
        val salonInfo = viewModel.getSalonInfo()
        binding.apply {
            tvWorkTimeSalon.text = salonInfo.workTime
            tvAddressMail.text = salonInfo.mail
            tvOperationMode.text = salonInfo.workMode
            tvLocationAddress.text = salonInfo.addressSalon
            tvPhoneNumber.text = salonInfo.phoneNumber
        }
    }

    private fun setPromotionsPager(data: ArrayList<PromotionsUI>) = with(
        binding.viewpagerHomePromotions
    ) {
        adapter = PromotionsPagerAdapter(data)
        binding.wormDotsIndicator.attachTo(this)
    }

}