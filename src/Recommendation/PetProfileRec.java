package Recommendation;

import Entity.PetProfiles.PetProfile;

public class PetProfileRec implements Recommendable<PetProfile>{
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public PetProfile retrieveNextAndUpdate() {
        return null;
    }
}
