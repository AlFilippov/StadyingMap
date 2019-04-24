package com.alphilippov.studyingmap.helperclasses;

import java.util.Objects;

public class ProfessionalDefinition {
    private final int mIdDefiniton;
    private final int mIndexDefinition;
    private final String mProfession;

    public ProfessionalDefinition(int idDefiniton, int indexDefinition, String profession) {
        mIdDefiniton = idDefiniton;
        mIndexDefinition = indexDefinition;
        mProfession = profession;
    }

    public int getIdDefiniton() {
        return mIdDefiniton;
    }

    public int getIndexDefinition() {
        return mIndexDefinition;
    }

    public String getProfession() {
        return mProfession;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfessionalDefinition that = (ProfessionalDefinition) o;
        return mIdDefiniton == that.mIdDefiniton &&
                mIndexDefinition == that.mIndexDefinition &&
                Objects.equals(mProfession, that.mProfession);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mIdDefiniton, mIndexDefinition, mProfession);
    }
}
