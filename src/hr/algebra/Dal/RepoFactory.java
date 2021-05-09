
package hr.algebra.Dal;

import hr.algebra.Dal.Sql.SqlRepository;

/**
 *
 * @author Marta
 */
public class RepoFactory {

    private RepoFactory() {
    }

    public static Repository getRepository() throws Exception {
        return new SqlRepository();
    }
}
