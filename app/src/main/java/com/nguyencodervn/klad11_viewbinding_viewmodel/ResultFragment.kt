package com.nguyencodervn.klad11_viewbinding_viewmodel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.nguyencodervn.klad11_viewbinding_viewmodel.databinding.FragmentResultBinding

class ResultFragment : Fragment(R.layout.fragment_result) {
    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!
    private val args: ResultFragmentArgs by navArgs()
//    private val viewModel: GameAndroidViewModelWithPara by activityViewModels {
//        GameAndroidViewModelWithParaFactory(3, requireActivity().application)
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentResultBinding.inflate(
            inflater, container, false
        )
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.resultTv.text = args.result
//      Lấy dữ liệu từ ViewModel dùng activityViewModels
//        binding.resultTv.text = viewModel.display
        binding.newGameBt.setOnClickListener {
            findNavController().navigate(R.id.gameFragment)
        }
    }
}
