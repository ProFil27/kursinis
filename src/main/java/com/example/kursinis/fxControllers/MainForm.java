package com.example.kursinis.fxControllers;

import com.example.kursinis.HelloApplication;
import com.example.kursinis.hibernateControl.CustomHibernate;
import com.example.kursinis.model.*;
import jakarta.persistence.EntityManagerFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.hibernate.query.Order;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MainForm implements Initializable {
    @FXML
    public Tab userTab;
    @FXML
    public Tab managementTab;
    @FXML
    public Tab foodTab;
    @FXML
    public TabPane tabsPane;
    public Button createButton;
    public ComboBox<BasicUser> clientList;
    public TextField priceField;
    public ComboBox<Restaurant> restaurantField;


    @FXML
    public TableView<UserTableParameters> userTable;
    @FXML
    public TableColumn<UserTableParameters, Integer> idCol;
    @FXML
    public TableColumn<UserTableParameters, String> userTypeCol;
    @FXML
    public TableColumn<UserTableParameters, String> usernameCol;
    @FXML
    public TableColumn<UserTableParameters, String> passwordCol;
    @FXML
    public TableColumn<UserTableParameters, String> nameCol;
    @FXML
    public TableColumn<UserTableParameters, String> surnameCol;
    @FXML
    public TableColumn<UserTableParameters, String> addressCol;
    @FXML
    public TableColumn<UserTableParameters, String> phoneNumCol;
    @FXML
    public TableColumn<UserTableParameters, Void> actionCol;
    public TextField titleField;
    public ComboBox<OrderStatus> filterStatus;
    public ComboBox<BasicUser> filterOrders;
    public DatePicker filterFrom;
    public DatePicker filterTo;
    public ComboBox<OrderStatus> orderStatusField;
    public ListView<Cuisine> foodList;
    public ListView<Cuisine> cusineList;
    public TextField titleCuisineField;
    public TextField cuisinePriceField;
    public TextArea ingredientsField;
    public ListView<Restaurant> restaurantList;
    public CheckBox isSpicy;
    public CheckBox isVegan;
    public ListView<BasicUser> basicUserList;
    public ListView<Chat> allChats;
    public ListView<Review> chatMessages;
    private ObservableList<UserTableParameters> data = FXCollections.observableArrayList();
    public ListView<FoodOrder> ordersList;
    public Tab chatTab;

    public AnchorPane foodPane;



    private EntityManagerFactory entityManagerFactory;
    private CustomHibernate customHibernate;
    private User currentUser;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userTable.setEditable(true);
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        userTypeCol.setCellValueFactory(new PropertyValueFactory<>("userType"));
        usernameCol.setCellValueFactory(new PropertyValueFactory<>("login"));
        passwordCol.setCellValueFactory(new PropertyValueFactory<>("password"));
        passwordCol.setCellFactory(TextFieldTableCell.forTableColumn());
        passwordCol.setOnEditCommit(event ->
        {
            event.getTableView().getItems().get(event.getTablePosition().getRow()).setPassword(event.getNewValue());
            User user = customHibernate.getEntityById(User.class, event.getTableView().getItems().get(event.getTablePosition().getRow()).getId());
            user.setPassword(event.getNewValue());
            customHibernate.update(user);
        });

        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        nameCol.setOnEditCommit(event ->
        {
            event.getTableView().getItems().get(event.getTablePosition().getRow()).setName(event.getNewValue());
            User user = customHibernate.getEntityById(User.class, event.getTableView().getItems().get(event.getTablePosition().getRow()).getId());
            user.setName(event.getNewValue());
            customHibernate.update(user);
        });

        surnameCol.setCellValueFactory(new PropertyValueFactory<>("surname"));
        surnameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        surnameCol.setOnEditCommit(event ->
        {
            event.getTableView().getItems().get(event.getTablePosition().getRow()).setSurname(event.getNewValue());
            User user = customHibernate.getEntityById(User.class, event.getTableView().getItems().get(event.getTablePosition().getRow()).getId());
            user.setSurname(event.getNewValue());
            customHibernate.update(user);
        });

        phoneNumCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        phoneNumCol.setCellFactory(TextFieldTableCell.forTableColumn());
        phoneNumCol.setOnEditCommit(event ->
        {
            event.getTableView().getItems().get(event.getTablePosition().getRow()).setPhoneNum(event.getNewValue());
            User user = customHibernate.getEntityById(User.class, event.getTableView().getItems().get(event.getTablePosition().getRow()).getId());
            user.setPhoneNumber(event.getNewValue());
            customHibernate.update(user);
        });

        addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        addressCol.setCellFactory(TextFieldTableCell.forTableColumn());
        addressCol.setOnEditCommit(event ->
        {
            UserTableParameters userParam = event.getTableView().getItems().get(event.getTablePosition().getRow());
            userParam.setAddress(event.getNewValue());

            User user = customHibernate.getEntityById(User.class, userParam.getId());

            if (user instanceof BasicUser)
            {
                ((BasicUser) user).setAddress(event.getNewValue());
                customHibernate.update(user);
            }
        });

        phoneNumCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        phoneNumCol.setCellFactory(TextFieldTableCell.forTableColumn());
        phoneNumCol.setOnEditCommit(event ->
        {
            event.getTableView().getItems().get(event.getTablePosition().getRow()).setPhoneNum(event.getNewValue());
            User user = customHibernate.getEntityById(User.class, event.getTableView().getItems().get(event.getTablePosition().getRow()).getId());
            user.setPhoneNumber(event.getNewValue());
            customHibernate.update(user);
        });
    }

    public void setData(EntityManagerFactory entityManagerFactory, User user) {
        this.entityManagerFactory = entityManagerFactory;
        this.currentUser = user;
        this.customHibernate = new CustomHibernate(entityManagerFactory);
        //setUserFormVisibility();
    }

//    private void setUserFormVisibility() {
//        if (currentUser instanceof User) {
//            //turbut nieko nedarom, gal kazka custom
//
//        } else if (currentUser instanceof Restaurant) {
//            //            altTab.setDisable(true);
//            tabsPane.getTabs().remove(altTab); //Man net nesugeneruos sito tabo
//        }
//    }

    public void reloadTableData() {
        if (userTab.isSelected()) {
            List<User> users = customHibernate.getAllRecords(User.class);
            for (User u : users) {
                UserTableParameters userTableParameters = new UserTableParameters();
                userTableParameters.setId(u.getId());
                userTableParameters.setUserType(u.getClass().getSimpleName());
                userTableParameters.setUsername(u.getUsername());
                userTableParameters.setPassword(u.getPassword());
                //baigti bendrus laukus
                if (u instanceof BasicUser) {
                    userTableParameters.setAddress(((BasicUser) u).getAddress());
                }
                data.add(userTableParameters);
            }
            userTable.getItems().addAll(data);
        } else if (managementTab.isSelected()) {
            clearAllOrderFields();
            List<FoodOrder> foodOrders = getFoodOrders();
            ordersList.getItems().addAll(foodOrders);
            clientList.getItems().addAll(customHibernate.getAllRecords(BasicUser.class));
            basicUserList.getItems().addAll(customHibernate.getAllRecords(BasicUser.class));
            restaurantField.getItems().addAll(customHibernate.getAllRecords(Restaurant.class));
            orderStatusField.getItems().addAll(OrderStatus.values());
        } else if (foodTab.isSelected()) {
            clearAllCuisineFields();
            restaurantList.getItems().addAll(customHibernate.getAllRecords(Restaurant.class));
        } else if (chatTab.isSelected()) {
            allChats.getItems().addAll(customHibernate.getAllRecords(Chat.class));
            chatMessages.getItems().addAll(customHibernate.getAllRecords(Review.class));
        }
    }
    private void clearAllOrderFields() {
        ordersList.getItems().clear();
        basicUserList.getItems().clear();
        clientList.getItems().clear();
        restaurantField.getItems().clear();
        titleField.clear();
        priceField.clear();
    }

    private void clearAllCuisineFields() {
        foodList.getItems().clear();
        cuisinePriceField.clear();
        titleCuisineField.clear();
        ingredientsField.clear();
        isSpicy.setSelected(false);
        isVegan.setSelected(false);
        restaurantList.getItems().clear();
    }

    public void registerNewUser() throws IOException {
        // surenku is lauku duomenis (login ir psw) ir tikrinu DB
        //sekmes atvejis - user yra -> atidaryti main forma
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("user-form.fxml"));
        Parent parent = fxmlLoader.load();
        UserForm userForm = fxmlLoader.getController();
        userForm.setData(entityManagerFactory, null, false);
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) createButton.getScene().getWindow();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public void createOrder(ActionEvent actionEvent) {
    }

    public void updateOrder(ActionEvent actionEvent) {
    }

    public void deleteOrder(ActionEvent actionEvent) {
    }

    private List<FoodOrder> getFoodOrders() {
        if (currentUser instanceof Restaurant) {
            return customHibernate.getRestaurantOrders((Restaurant) currentUser);
        } else {
            return customHibernate.getAllRecords(FoodOrder.class);
        }
    }

    public void loadRestaurantMenuForOrder(ActionEvent actionEvent) {
    }

    public void filterOrders(ActionEvent actionEvent) {
    }

    public void createNewMenuItem(ActionEvent actionEvent) {
    }

    public void updateMenuItem(ActionEvent actionEvent) {

    }

    public void updateChat(ActionEvent actionEvent) {
    }
}
