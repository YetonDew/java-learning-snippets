import java.util.Map;
import java.util.TreeMap;

final public class RoleDataBase {
    final private static Map<String,RolesEnum>
                roles = new TreeMap<String,RolesEnum>();
    static {
        roles.put("smith",  RolesEnum.ADMIN);
        roles.put("doe",    RolesEnum.GUEST);
        roles.put("miller", RolesEnum.BOSS);
        roles.put("werner", RolesEnum.USER);
    }

    public static RolesEnum get(String user) {
        RolesEnum role = roles.get(user);
        return  role != null ? role : RolesEnum.GUEST;
    }
}
