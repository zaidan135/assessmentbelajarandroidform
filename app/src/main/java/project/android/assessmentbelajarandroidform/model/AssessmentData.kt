package project.android.assessmentbelajarandroidform.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AssessmentData(
    val nim: String,
    val namaLengkap: String,
    val semester: String,
    val deviceForCoding: String,
    val osDevice: String,
    val namaVersiOS: String,
    val ram: String,
    val namaCPU: String,
    val deployment: String,
    val merkHP: String,
    val osHPVersi: String,
    val ukuranHP: String,
    val penggunaanInternet: String,
    val installedAndroidStudio: Boolean,
    val versiAndroidStudio: String
) : Parcelable

// Minggu 18 Mei 2025

/*
NIM   : 10122231
NAMA  : Zaidan Febriandi
Kelas : IF-6
*/