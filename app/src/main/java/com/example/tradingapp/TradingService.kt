package com.example.tradingapp

import android.app.Service
import android.content.Intent
import android.os.IBinder
import java.time.LocalTime

class TradingService : Service() {
    private var highLine = 0.0
    private var lowLine = 0.0
    private var tradeExecuted = false

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Thread {
            while (true) {
                val now = LocalTime.now()

                // 1. 9:45 AM Range Calculation
                if (now.hour == 9 && now.minute == 46 && highLine == 0.0) {
                    val h = 54848.0; val l = 54356.0 // Fetch from API
                    if ((h - l) <= 325.0) {
                        highLine = h + 5.0
                        lowLine = l - 5.0
                    }
                }

                // 2. 3:15 PM Hard Exit
                if (now.hour == 15 && now.minute == 15) {
                    // Logic to send Market Buy Exit
                    stopSelf()
                    break
                }
                Thread.sleep(5000)
            }
        }.start()
        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? = null
}
