package com.example.pijetin.feature.Settings

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.example.pijetin.R
import com.example.pijetin.databinding.AlertDialogLogoutSuccesBinding
import com.example.pijetin.feature.Login.Login
import com.example.pijetin.feature.OnBoarding.OnBoarding

class AlertDialogLogoutSucces: DialogFragment() {
    lateinit var binding: AlertDialogLogoutSuccesBinding
    override fun onCreateDialog( savedInstanceState: Bundle?): Dialog {
        return Dialog(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AlertDialogLogoutSuccesBinding.inflate(layoutInflater, container, false)
        dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.setCanceledOnTouchOutside(false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.cardView4.setOnClickListener {
            dialog?.onBackPressed()
        }
        binding.cardView5.setOnClickListener {
            startActivity(Intent(activity, Login::class.java ))
        }
    }
}