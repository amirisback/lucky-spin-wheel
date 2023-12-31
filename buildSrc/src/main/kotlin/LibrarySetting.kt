import ProjectSetting.BASE_PACAKGE_NAME

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

object LibrarySetting {

    const val GITHUB_ACCOUNT = "frogobox"
    const val GITHUB_REPOSITORY = "lucky-spin-wheel"

    const val LIB_NAME = "spinwheel"

    const val ARTIFACT_ID = GITHUB_REPOSITORY
    const val GROUP_ID = "com.github.$GITHUB_ACCOUNT"

    const val NAME_SPACE = "$BASE_PACAKGE_NAME.$LIB_NAME"

    const val MAVEN_URI = "https://maven.pkg.github.com/$GITHUB_ACCOUNT/$GITHUB_REPOSITORY"

}