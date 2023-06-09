package com.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.geeksfit.R
import com.example.geeksfit.data.remote.model.login.LoginBody
import com.example.geeksfit.data.remote.model.login.RegistrationBody
import com.example.geeksfit.databinding.FragmentRegisterBinding
import com.example.geeksfit.ui.dashboard.RegistrationViewModel
import com.example.geeksfit.ui.showToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : Fragment() {


    private val vm: RegistrationViewModel by viewModels()
    private lateinit var binding: FragmentRegisterBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentRegisterBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClick()

    }

    private fun addRegister() {
        vm.addRegistration(
            RegistrationBody(
                email = binding.RgTextPersonName2.text.toString(),
                password = binding.RgTextPersonName3.text.toString(),
                username = binding.RgTextPersonName1.text.toString()
            )
        ).observe(viewLifecycleOwner) { registerResponse ->
            vm.postLogin(LoginBody(registerResponse.username, registerResponse.password))
                .observe(viewLifecycleOwner) { loginResponse ->
                    vm.saveTokens(loginResponse)
                    requireActivity().showToast("Успешно")
                    findNavController().navigate(R.id.payFragment)
                }

        }
    }

    private fun onClick() {
        binding.RgNavigateBack.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.registerButton1.setOnClickListener {
            if (binding.RgTextPersonName3.text.toString() == binding.RgTextPersonName4.text.toString()) {
                addRegister()
            } else {
                requireActivity().showToast("Пороли не совпадают")
            }

        }
    }
}