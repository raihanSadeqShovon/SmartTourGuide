package cryptenet.thanatos.util;

public class DebugUtil {
    public static final String DEBUG_KEY = "th";
    public static final String TAG = DebugUtil.class.getSimpleName() + DEBUG_KEY;

    public static String getTag (String className) {
        return className + DEBUG_KEY;
    }
}
