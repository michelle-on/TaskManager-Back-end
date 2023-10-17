package com.example.taskManager.Utils;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.example.taskManager.models.UserModel;

public class Utils {
     public static void doPasswordHash(UserModel userModel) {
         userModel.setPassword(BCrypt.withDefaults().hashToString(12, userModel.getPassword().toCharArray()));
     }
}
