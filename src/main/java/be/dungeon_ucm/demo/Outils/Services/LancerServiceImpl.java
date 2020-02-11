package be.dungeon_ucm.demo.Outils.Services;

import be.dungeon_ucm.demo.Outils.Model.LancerDeDes;

import java.util.Random;

public class LancerServiceImpl implements LancerService {

    @Override
    public int lancer(LancerDeDes de) {
        Random r = new Random(de.getMin());
        return r.nextInt(de.getMax());
    }

    @Override
    public void modifierTout(LancerDeDes de, int max, int min) {
        de.setMax(max);
        de.setMin(min);
    }

    @Override
    public void modifierMax(LancerDeDes de, int max) {
        de.setMax(max);
    }

    @Override
    public void modifierMin(LancerDeDes de, int min) {
        de.setMin(min);
    }

}
