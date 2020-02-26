package be.dungeon_ucm.demo.BL.Services.InterfaceService;

import be.dungeon_ucm.demo.BL.Models.Combat.Equipe;

public interface SalleRelaxService {
    boolean sauvegarde(Equipe equipe);
    Equipe repos(Equipe equipe);
}
