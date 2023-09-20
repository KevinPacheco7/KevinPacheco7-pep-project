package Service;

import DAO.AccountDAO;
import Model.Account;

public class AccountService {
    AccountDAO accountDAO;

    public AccountService(){
        accountDAO = new AccountDAO();
    }

    public Account addAccount(Account account){
        String username = account.getUsername();
        Account accountTest = accountDAO.getAccountbyUsername(username);
        if(account.getPassword().length()<4){
            return null;
        }
        if(username.equals("")){
            return null;
        }
        if(accountTest==null){
            return accountDAO.insertAccount(account);
        }
        return null;
    }

    public Account loginAccount(String username, String password){
        if(accountDAO.getAccountbyUsername(username)==null){
            return null;
        }
        if(username.equals(accountDAO.getAccountbyUsername(username).getUsername())){
            if(password.equals(accountDAO.getAccountbyUsername(username).getPassword())){
                return accountDAO.getAccountbyUsername(username);
            }
        }
        return null;
    }
}