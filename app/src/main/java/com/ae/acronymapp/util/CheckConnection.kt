package com.ae.acronymapp.util

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.InetSocketAddress
import java.net.Socket
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Class to check internet connection
 */
@Singleton
class CheckConnection @Inject constructor() {

    companion object {
        private const val HOSTNAME: String = "8.8.8.8"
        private const val PORT: Int = 53
        private const val TIMEOUT: Int = 1500
    }

    /**
     * Check connection
     * @return true when connection is available and
     * false when it isn't
     */
    suspend fun connectionIsAvailable(): Boolean = withContext(Dispatchers.IO) {
        return@withContext try {
            val sock = Socket()
            val socketAddress = InetSocketAddress(HOSTNAME, PORT)
            sock.connect(socketAddress, TIMEOUT)
            sock.close()
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }
}
