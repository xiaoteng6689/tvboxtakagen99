package com.simplelife

import android.app.Application
import com.tencent.mmkv.MMKV

/**
 *
 * Copyright (C), 2024 Potato-66, All rights reserved.
 * 创建时间: 2024/2/27
 * @since 1.0
 * @version 1.0
 * @author Potato-66
 */
open class TVApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        MMKV.initialize(this)
    }
}