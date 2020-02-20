package be.dungeon_ucm.demo.Outils.Services;

import org.springframework.stereotype.Service;

@Service
public class GenerateurIDpersonnageServicelmpl {

    private static Long IDNEXT;

    public GenerateurIDpersonnageServicelmpl() {
        IDNEXT= 0L;
    }

    public Long getIDNEXT() {
        IDNEXT++;
        return IDNEXT;
    }
}
