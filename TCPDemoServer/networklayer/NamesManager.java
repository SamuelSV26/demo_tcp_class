public class NamesManager {
 public String generateMessage(String name, String lastName) {
    StringBuilder sb = new StringBuilder();
    sb.append("Name: ")
        .append(name)
        .append(" Last Name: ")
        .append(lastName);

     return sb.toString();
 }
}
