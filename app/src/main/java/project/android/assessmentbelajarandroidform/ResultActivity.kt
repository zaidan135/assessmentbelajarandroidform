package project.android.assessmentbelajarandroidform

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import project.android.assessmentbelajarandroidform.databinding.ActivityResultBinding
import project.android.assessmentbelajarandroidform.model.AssessmentData

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<AssessmentData>("ASSESSMENT_DATA")

        if (data == null) {
            finish()
            return
        }

        displayData(data)

        binding.btnDevInfo.setOnClickListener {
            showDeveloperDialog()
        }
    }

    private fun displayData(data: AssessmentData) {
        binding.tvNim.text = "${getString(R.string.nim)}: ${data.nim}"
        binding.tvNamaLengkap.text = "${getString(R.string.nama_lengkap)}: ${data.namaLengkap}"
        binding.tvSemester.text = "${getString(R.string.semester)}: ${data.semester}"
        binding.tvDeviceForCoding.text = "${getString(R.string.device_coding)}: ${data.deviceForCoding}"
        binding.tvOsDevice.text = "${getString(R.string.os_device)}: ${data.osDevice}"
        binding.tvNamaVersiOS.text = "${getString(R.string.nama_versi_os)}: ${data.namaVersiOS}"
        binding.tvRam.text = "${getString(R.string.ram)}: ${data.ram}"
        binding.tvNamaCPU.text = "${getString(R.string.nama_cpu)}: ${data.namaCPU}"
        binding.tvDeployment.text = "${getString(R.string.deployment)}: ${data.deployment}"
        binding.tvMerkHP.text = "${getString(R.string.merk_hp)}: ${data.merkHP}"
        binding.tvOsHPVersi.text = "${getString(R.string.os_hp_versi)}: ${data.osHPVersi}"
        binding.tvUkuranHP.text = "${getString(R.string.ukuran_hp)}: ${data.ukuranHP}"
        binding.tvPenggunaanInternet.text = "${getString(R.string.penggunaan_internet)}: ${data.penggunaanInternet}"
        binding.tvSudahInstallAndroidStudio.text = "${getString(R.string.installed_android_studio)}: ${if (data.installedAndroidStudio) "Yes" else "No"}"
        binding.tvVersiAndroidStudio.text = "${getString(R.string.versi_android_studio)}: ${data.versiAndroidStudio}"
    }

    private fun showDeveloperDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.layout_developer_info)

        val btnClose = dialog.findViewById<Button>(R.id.btnCloseDialog)
        btnClose.setOnClickListener { dialog.dismiss() }

        dialog.show()
    }
}

// Minggu 18 Mei 2025

/*
NIM   : 10122231
NAMA  : Zaidan Febriandi
Kelas : IF-6
*/