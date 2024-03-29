package com.geektech.beauty.presentation.ui.fragments.main.home.salon

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.beauty.R
import com.geektech.beauty.core.base.BaseFragment
import com.geektech.beauty.core.extensions.navigateSafely
import com.geektech.beauty.databinding.FragmentSalonBinding
import com.geektech.beauty.presentation.models.PromotionsUI
import com.geektech.beauty.presentation.ui.adapters.*
import com.geektech.beauty.presentation.ui.adapters.home.salon.CustomersFeedbacksAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SalonFragment : BaseFragment<FragmentSalonBinding, SalonViewModel>(R.layout.fragment_salon) {
    override val binding by viewBinding(FragmentSalonBinding::bind)
    override val viewModel by viewModels<SalonViewModel>()
    private val buttonServicesAdapter = ButtonServicesAdapter(this::onCategoryClickListener)
    private val topSpecialistAdapter = TopSpecialistAdapter(this::onItemClick)
    private val customersFeedbacksAdapter = CustomersFeedbacksAdapter()
    private val salonOurInteriorAdapter = InteriorAdapter()
    private val salonOurSpecialistWorkAdapter = OurSpecialistWorkAdapter()

    override fun initialize() {
        setPromotionsPager(viewModel.getPromotionBanners())
        setSalonInformation()
        setButtonServices()
        setTopSpecialist()
        setSalonInterior()
        setSalonOurSpecialistWork()
        setSubscribeToCustomersFeedbacks()
    }

    private fun setSalonInterior() {
        binding.recyclerViewInterior.adapter = salonOurInteriorAdapter
        salonOurInteriorAdapter.submitList(viewModel.getSalonInterior())
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

    private fun setSalonOurSpecialistWork() {
        binding.recyclerViewWorksMasters.adapter = salonOurSpecialistWorkAdapter
        salonOurSpecialistWorkAdapter.submitList(viewModel.getOurSpecialistWork())
    }

    private fun setSubscribeToCustomersFeedbacks() {
        binding.recyclerViewFeedback.adapter = customersFeedbacksAdapter
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.customersFeedbacksState.collect {
                customersFeedbacksAdapter.submitList(it)
            }
        }
    }

    private fun setPromotionsPager(data: ArrayList<PromotionsUI>) = with(
        binding.viewpagerHomePromotions
    ) {
        adapter = PromotionsPagerAdapter(data)
        binding.wormDotsIndicator.attachTo(this)
    }

    private fun onCategoryClickListener() {
        findNavController().navigateSafely(R.id.action_salonFragment_to_detailedServicesCategoryFragment)
    }

    private fun onItemClick() {
        findNavController().navigateSafely(R.id.action_salonFragment_to_specialistProfileFragment)
    }

    override fun performListeners() {
        binding.btnMakeAnAppointment.setOnClickListener {
            findNavController().navigateSafely(R.id.action_salonFragment_to_detailedServicesCategoryFragment)
        }
    }

}