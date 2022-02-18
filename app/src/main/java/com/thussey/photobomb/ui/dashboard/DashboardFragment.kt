package com.thussey.photobomb.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.thussey.photobomb.R
import com.thussey.photobomb.data.model.util.DividerItemDecorator
import com.thussey.photobomb.data.model.util.UiState
import com.thussey.photobomb.databinding.FragmentDashboardBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DashboardFragment : Fragment() {

    private val viewModel: DashboardViewModel by viewModels()
    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        ContextCompat.getDrawable(requireContext(), R.drawable.divider)?.let { drawable ->
            binding.dashboardRV.addItemDecoration(DividerItemDecorator(drawable))
        }


        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.dashboardState.collectLatest { dashboardState ->
                if (dashboardState.uiState == UiState.LOADED) {
                    binding.dashboardRV.adapter = DashboardAdapter(dashboardState.favorites)
                }
            }
        }
        viewModel.getFavorites()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}