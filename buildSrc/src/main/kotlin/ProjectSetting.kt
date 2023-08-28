/**
 * Created by faisalamir on 19/09/21
 *
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2021 FrogoBox Inc.
 * All rights reserved
 *
 */

object ProjectSetting {

    // Project Name
    const val NAME_APP = "KickStart Library"

    // ---------------------------------------------------------------------------------------------

    const val VERSION_MAJOR = 0
    const val VERSION_MINOR = 0
    const val VERSION_PATCH = 1

    const val PROJECT_VERSION_CODE = (VERSION_MAJOR * 100) + (VERSION_MINOR * 10) + (VERSION_PATCH * 1)
    const val PROJECT_VERSION_NAME = "$VERSION_MAJOR.$VERSION_MINOR.$VERSION_PATCH"

    // ---------------------------------------------------------------------------------------------

    const val PROJECT_MIN_SDK = 21
    const val PROJECT_COMPILE_SDK = 33
    const val PROJECT_TARGET_SDK = PROJECT_COMPILE_SDK

    // ---------------------------------------------------------------------------------------------

    const val APP_DOMAIN = "com"
    const val APP_PLAY_CONSOLE = "frogobox"
    const val APP_NAME_SPACE = "kickstartlibrary"

    const val BASE_PACAKGE_NAME = "$APP_DOMAIN.$APP_PLAY_CONSOLE"

    val NAME_APP_ID = NAME_APP.toLowerCase().replace(" ", "")
    val NAME_APK = NAME_APP.toLowerCase().replace(" ", "-")
    val NAME_DB = NAME_APP.toLowerCase().replace(" ", "_")

    val PROJECT_APP_ID = "$BASE_PACAKGE_NAME.$NAME_APP_ID"
    val PROJECT_APP_NAME_SPACE = "$BASE_PACAKGE_NAME.$APP_NAME_SPACE"

    val DB = "\"$NAME_DB.db\""

    // ---------------------------------------------------------------------------------------------

    const val PLAYSTORE_STORE_FILE = "frogoboxmedia.jks"
    const val PLAYSTORE_STORE_PASSWORD = "amirisback"
    const val PLAYSTORE_KEY_ALIAS = "frogoisback"
    const val PLAYSTORE_KEY_PASSWORD = "amirisback"

    // ---------------------------------------------------------------------------------------------

    const val DEBUG_ATTRIBUTE = "Dev"
    const val NAME_APP_DEBUG = "${ProjectSetting.NAME_APP} $DEBUG_ATTRIBUTE"

}