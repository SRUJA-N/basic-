package serives;

import com.sun.corba.se.impl.presentation.rmi.IDLTypeException;
import jdk.internal.org.objectweb.asm.TypeReference;
import ticket_booking.entities.User;
import java.util.List;
import java.io.File;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserTrainService {
    private User user;
    private List<User> userList;
    private static ObjectMapper objectMapper=new ObjectMapper();
    private static final String USERPATH="../localdb/user.json";
    public UserTrainService(User user1) throws IdException
    {
        this.user = user1;
        File users=new File(USERPATH);
        userList=objectMapper.readValue(users,new TypeReference<List<User>>(){});

    }
}