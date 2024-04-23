package com.example.spido_matrix2

import android.app.Application
import android.content.Context
import com.example.spido_matrix2.util.RoomDisplayNameFallbackProviderImpl
import org.matrix.android.sdk.api.Matrix
import org.matrix.android.sdk.api.MatrixConfiguration
import timber.log.Timber

class SampleApp : Application() {

    private lateinit var matrix: Matrix

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        // You should first create a Matrix instance before using it
        createMatrix()
        // You can then grab the authentication service and search for a known session
        val lastSession = matrix.authenticationService().getLastAuthenticatedSession()
        if (lastSession != null) {
            SessionHolder.currentSession = lastSession
            // Don't forget to open the session and start syncing.

            lastSession.open()
            lastSession.syncService().startSync(true)
        }
    }

    private fun createMatrix() {
        matrix = Matrix(
            context = this,
            matrixConfiguration = MatrixConfiguration(
                roomDisplayNameFallbackProvider = RoomDisplayNameFallbackProviderImpl()
            )
        )
    }

    companion object {
        fun getMatrix(context: Context): Matrix {
            return (context.applicationContext as SampleApp).matrix
        }
    }
}
