package splitwise.dao;

import splitwise.model.expense.Expense;
import splitwise.model.user.User;

import java.util.List;
import java.util.Map;

/*splitwise
 split wise*/
public interface SplitwiseDao {
    void addUser(User user);

    void addExpense(Expense expense);

    List<User> getUsers();

    Map<String, Map<String, Double>> getBalanceSheet();
}
