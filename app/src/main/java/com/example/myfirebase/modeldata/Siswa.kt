package com.example.myfirebase.modeldata


data class Siswa(
    val id: Long = 0,
    val nama: String = "",
    val alamat: String = "",
    val telpon: String = ""
)

data class DetailsSiswa(
    val id: Long = 0,
    val nama: String = "",
    val alamat: String = "",
    val telpon: String = ""
)

fun DetailsSiswa.toDataSiswa(): Siswa = Siswa(id, nama, alamat, telpon)
fun Siswa.toDetailsSiswa(): DetailsSiswa = DetailsSiswa(id, nama, alamat, telpon)

data class UIStateSiswa(
    val detailsSiswa: DetailsSiswa = DetailsSiswa(),
    val isEntryValid: Boolean = false
)

fun Siswa.toUiStateSiswa(isEntryValid: Boolean = false): UIStateSiswa = UIStateSiswa(
    detailsSiswa = this.toDetailsSiswa(),
    isEntryValid = isEntryValid
)