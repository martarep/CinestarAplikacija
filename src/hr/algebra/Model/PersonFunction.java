
package hr.algebra.Model;

/**
 *
 * @author Marta
 */
public enum PersonFunction {
    DIRECTOR(1),
    ACTOR(2),
    DIRECTORACTOR(3);

    private final int personFunctionID;

    private PersonFunction(int personFunctionID) {
        this.personFunctionID = personFunctionID;
    }

    public int getPersonFunctionID() {
        return personFunctionID;
    }

    public static PersonFunction getPersonFunctionById(int id) {
        if (id == DIRECTOR.getPersonFunctionID()) {
            return DIRECTOR;
        } else if (id == ACTOR.getPersonFunctionID()) {
            return ACTOR;
        } else {
            return DIRECTORACTOR;
        }
    }

    @Override
    public String toString() {
        return Integer.toString(personFunctionID);
    }
}
