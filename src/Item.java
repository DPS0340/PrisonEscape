public interface Item {
    //Interface that must be implemented by any item Objects in the API.
    //Item Objects are to be stored in Room Objects(Defined in the API)
    public String getDescription(); //All items must have a description to be displayed as output.
    public String getName(); //All items must have a name to identify themselves.
}
