package course.functional.chapter6Funtion.projectSales;

import course.functional.chapter6Funtion.overall.BiFunction;


public class SalesQueryUtils {

    public static BiFunction<Customer,Integer,SportRecord> getSportRecord(Customer[] customerList){
        return (x,z)-> {
            SportRecord sportRecord = null;
            for (int i = z; i < customerList.length && sportRecord == null ; ++i) {
                if (customerList[i].getSport().equals(x.getSport())){
                    sportRecord = new SportRecord(customerList[i].getName(), customerList[i].getPhoneNum(),
                            i, customerList[i].getTeam());
                }
            }
            return sportRecord;
        };
    }

    public static BiFunction<Customer,Integer,GpaRecord> getGpaRecord(Customer[] customerList){
        return (x,z)-> {
            GpaRecord gpaRecord = null;
            for (int i = z; i < customerList.length && gpaRecord == null ; ++i) {
                if (customerList[i].getGpa() >= x.getGpa()){
                    gpaRecord = new GpaRecord(customerList[i].getName(), customerList[i].getPhoneNum(),
                            i, customerList[i].getSubject());
                }
            }
            return gpaRecord;
        };
    }

    public static BiFunction<Customer,Integer,FriendsRecord> getFriendsRecord(Customer[] customerList){
        return (x,z)-> {
            FriendsRecord friendsRecord = null;
            for (int i = z; i < customerList.length && friendsRecord == null ; ++i) {
                if (customerList[i].getNumFriends() >= x.getNumFriends()){
                    friendsRecord = new FriendsRecord(customerList[i].getName(), customerList[i].getPhoneNum(),
                            i, customerList[i].getFriends());
                }
            }
            return friendsRecord;
        };
    }

}
