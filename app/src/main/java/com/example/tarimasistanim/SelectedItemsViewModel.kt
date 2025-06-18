//package com.example.tarimasistanim.viewmodel
//
//import androidx.compose.runtime.mutableStateListOf
//import androidx.lifecycle.ViewModel
//
//data class DikiliBitki(
//    val id: Int,
//    val resId: Int,
//    val detayResId: Int,
//    val title: String,
//    val sulamaGunu: Int,
//    val ekimTarihi: Long = System.currentTimeMillis()
//)
//class SelectedItemsViewModel : ViewModel() {
//    val selectedItems = mutableStateListOf<Int>()
//
//    fun addItem(resId: Int) {
//        if (!selectedItems.contains(resId)) {
//            selectedItems.add(resId)
//        }
//    }
//
//    fun removeItem(resId: Int) {
//        selectedItems.remove(resId)
//    }
//
//    class SelectedItemsViewModel : ViewModel() {
//        val dikiliBitkiler = mutableStateListOf<DikiliBitki>()
//
//        fun addBitki(bitki: DikiliBitki) {
//            if (dikiliBitkiler.none { it.id == bitki.id }) {
//                dikiliBitkiler.add(bitki)
//            }
//        }
//    }
//
//    val dikiliBitkiler = mutableStateListOf<DikiliBitki>()
//
//    fun addBitki(bitki: DikiliBitki) {
//        if (dikiliBitkiler.none { it.id == bitki.id }) {
//            dikiliBitkiler.add(bitki)
//        }
//    }
//}

// SelectedItemsViewModel.kt
package com.example.tarimasistanim.viewmodel

import android.content.Context
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.work.Data
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit

// Bitki veri modeli
data class DikiliBitki(
    val id: Int,
    val resId: Int,
    val detayResId: Int,
    val title: String,
    val sulamaGunu: Int,
    val ekimTarihi: Long = System.currentTimeMillis()
)

class SelectedItemsViewModel : ViewModel() {
    val dikiliBitkiler = mutableStateListOf<DikiliBitki>()

    fun addBitki(bitki: DikiliBitki) {
        if (dikiliBitkiler.none { it.id == bitki.id }) {
            dikiliBitkiler.add(bitki)
        }
    }

    fun removeBitki(id: Int) {
        dikiliBitkiler.removeAll { it.id == id }
    }
}

