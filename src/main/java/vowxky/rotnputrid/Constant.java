package vowxky.rotnputrid;

import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class was created by Vowxky.
 * All rights reserved to the developer.
 */

public class Constant {
    public static final String MOD_ID = "rotnputrid";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static Identifier id (String path){
        return new Identifier(MOD_ID, path);
    }
}
