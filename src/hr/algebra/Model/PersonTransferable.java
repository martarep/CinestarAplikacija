package hr.algebra.Model;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

/**
 *
 * @author Marta
 */
public class PersonTransferable implements Transferable {

    public static final DataFlavor PERSON_FLAVOR = new DataFlavor(Person.class, "Person");

    public static final DataFlavor[] SUPPORTED_FLAVORS = {PERSON_FLAVOR};

    private final Person person;

    public PersonTransferable(Person person) {
        this.person = person;
    }

    @Override
    public DataFlavor[] getTransferDataFlavors() {
        return SUPPORTED_FLAVORS;
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor) {
        return flavor.equals(PERSON_FLAVOR);
    }

    @Override
    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
        if (flavor.equals(PERSON_FLAVOR)) {
            return person;
        }
        throw new UnsupportedFlavorException(flavor);
    }

}
