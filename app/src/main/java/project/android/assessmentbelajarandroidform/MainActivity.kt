package project.android.assessmentbelajarandroidform

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import project.android.assessmentbelajarandroidform.databinding.ActivityMainBinding
import project.android.assessmentbelajarandroidform.model.AssessmentData
import android.content.Intent


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val semesterOptions = arrayOf("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII")
    private val deviceOptions = arrayOf("Laptop", "PC Desktop", "Tablet", "Smartphone")
    private val osDeviceOptions = arrayOf("Windows", "MacOS", "Linux", "Android", "iOS")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupDropdowns()
        setupListeners()
    }

    private fun setupDropdowns() {
        val semesterAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, semesterOptions)
        binding.dropdownSemester.setAdapter(semesterAdapter)

        val deviceAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, deviceOptions)
        binding.dropdownDeviceCoding.setAdapter(deviceAdapter)

        val osDeviceAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, osDeviceOptions)
        binding.dropdownOsDevice.setAdapter(osDeviceAdapter)
    }

    private fun setupListeners() {
        binding.btnSubmit.setOnClickListener {
            if (validateInput()) {
                val data = collectData()
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("ASSESSMENT_DATA", data) // Mengirim data ke ResultActivity
                startActivity(intent)
            }
        }
    }

    private fun validateInput(): Boolean {
        var valid = true

        if (binding.etNim.text.isNullOrBlank()) {
            binding.etNim.error = getString(R.string.nim_error)
            valid = false
        }

        if (binding.etNamaLengkap.text.isNullOrBlank()) {
            binding.etNamaLengkap.error = getString(R.string.nama_error)
            valid = false
        }

        if (binding.dropdownSemester.text.isNullOrBlank()) {
            binding.dropdownSemester.error = getString(R.string.semester_error)
            valid = false
        }

        if (binding.dropdownDeviceCoding.text.isNullOrBlank()) {
            binding.dropdownDeviceCoding.error = getString(R.string.device_coding_error)
            valid = false
        }

        if (binding.dropdownOsDevice.text.isNullOrBlank()) {
            binding.dropdownOsDevice.error = getString(R.string.os_device_error)
            valid = false
        }

        return valid
    }

    private fun collectData(): AssessmentData {
        return AssessmentData(
            nim = binding.etNim.text.toString(),
            namaLengkap = binding.etNamaLengkap.text.toString(),
            semester = binding.dropdownSemester.text.toString(),
            deviceForCoding = binding.dropdownDeviceCoding.text.toString(),
            osDevice = binding.dropdownOsDevice.text.toString(),
            namaVersiOS = binding.etNamaVersiOS.text.toString(),
            ram = binding.etRam.text.toString(),
            namaCPU = binding.etNamaCPU.text.toString(),
            deployment = binding.etDeployment.text.toString(),
            merkHP = binding.etMerkHP.text.toString(),
            osHPVersi = binding.etOsHPVersi.text.toString(),
            ukuranHP = binding.etUkuranHP.text.toString(),
            penggunaanInternet = binding.etPenggunaanInternet.text.toString(),
            installedAndroidStudio = binding.cbInstalledAndroidStudio.isChecked,
            versiAndroidStudio = binding.etVersiAndroidStudio.text.toString()
        )
    }
}

// Minggu 18 Mei 2025

/*
NIM   : 10122231
NAMA  : Zaidan Febriandi
Kelas : IF-6
*/
