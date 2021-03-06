package com.sample.experiments.domain

import kotlinx.coroutines.flow.Flow

interface DownloadUseCase {

    fun download(item: DownloadableItem): Flow<DownloadStatus>
    fun status(item: DownloadableItem): DownloadStatus?

    sealed class DownloadStatus {
        data class Downloading(val percent: Int) : DownloadStatus()
        object Finished : DownloadStatus()
        object Error : DownloadStatus()
    }
}


interface GetItemsUseCase {
    operator fun invoke(): List<DashboardItem>
}
