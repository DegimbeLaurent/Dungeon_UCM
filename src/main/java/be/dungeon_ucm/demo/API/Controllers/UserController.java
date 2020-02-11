package be.dungeon_ucm.demo.API.Controllers;

import be.dungeon_ucm.demo.API.DTO.USER.LogUserDTO;
import be.dungeon_ucm.demo.API.DTO.USER.PostUserDTO;
import be.dungeon_ucm.demo.API.DTO.USER.UserDTO;
import be.dungeon_ucm.demo.DAL.DAO.UserDAO;
import be.dungeon_ucm.demo.DAL.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/User")
@CrossOrigin
public class UserController {

    private UserDAO userDAO;

    @Autowired
    public UserController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping("")
    public ResponseEntity<List<UserDTO>> getAll(){
        List<User> users = userDAO.findAll();
        System.out.println(users);

        return ResponseEntity.ok(users.stream().map(UserDTO::new).collect(Collectors.toList()));
    }
    @PostMapping("/reg")
    public ResponseEntity<UserDTO> post(@RequestBody @Valid PostUserDTO postUserDTO){
        System.out.println(postUserDTO.getPseudo());
        System.out.println(postUserDTO.getMdp());
        User user = postUserDTO.toEntity();
        userDAO.save(user);
        System.out.println(user.getId());
        return ResponseEntity.ok(new UserDTO(user));
    }
    @PostMapping("/log")
    public Boolean log(@RequestBody @Valid LogUserDTO logUserDTO ){
        System.out.println(logUserDTO.getPseudo());
        System.out.println(logUserDTO.getMdp());
        if(userDAO.getByPseudo(logUserDTO.getPseudo()).isPresent()){
            Optional<User> Opuser = userDAO.getByPseudo(logUserDTO.getPseudo());
            User user = Opuser.get();
            if(user.getMdp().equals(logUserDTO.getMdp())) {
                return true;
            }
        }
        return false;
    }
}
