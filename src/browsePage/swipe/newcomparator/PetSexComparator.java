package browsePage.swipe.newcomparator;

import entity.petProfile.PetProfile;
import entity.user.AppUser;

import java.util.Comparator;
class PetSexComparator implements Comparator<PetProfile> {
    private String idealSex;

    public PetSexComparator(String idealSex) {
        this.idealSex = idealSex;
    }

    @Override
    public int compare(PetProfile p1, PetProfile p2) {
        // Assuming 'sex' attribute is a String with values "male" or "female"
        if (idealSex.equals(AppUser.NONE)){
            return 0;
        }
        else{
        boolean p1Match = p1.getSex().equals(idealSex);
        boolean p2Match = p2.getSex().equals(idealSex);
        return Boolean.compare(p1Match, p2Match);
        }
    }
}
