package gui;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.entities.Department;
import model.entities.Seller;
import model.sevices.SellerService;

public class SellerListController implements Initializable{

	private SellerService service;
	
	@FXML
	private Button btNew;
	
	@FXML
	private TableView<Seller> tableViewSeller;
	
	@FXML
	private TableColumn<Seller, String> sellerName;
	
	@FXML
	private TableColumn<Seller, String> departmentName;
	
	private ObservableList<Seller> obsList;
	
	@FXML
	public void onBtNewAction() {

	}
	
	public void updateTableView() {
		List<Seller> seller = service.findAll();
		obsList = FXCollections.observableArrayList(seller);
		tableViewSeller.setItems(obsList);
	}
	
	public void initializeNodes() {
		sellerName.setCellValueFactory(new PropertyValueFactory<>("name"));
		//departmentName.setCellValueFactory();
		Stage stage = (Stage) EnterViewController.getMainViewScene().getWindow();
		tableViewSeller.prefHeightProperty().bind(stage.heightProperty());
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
	}
	
	public void setSellerService(SellerService service) {
		this.service = service;
	}

}
