package org.controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.model.Categoria;
import org.model.Despesa;
import org.model.DespesaDAO; // Ou DespesaService se preferir
import java.time.LocalDate;
import java.util.List;

public class DespesaController {

    @FXML private TextField descricaoField;
    @FXML private TextField valorField;
    @FXML private DatePicker dataPicker;
    @FXML private ComboBox<Categoria> categoriaBox;

    @FXML private TableView<Despesa> table;
    @FXML private TableColumn<Despesa, Integer> colId;
    @FXML private TableColumn<Despesa, String> colDescricao;
    @FXML private TableColumn<Despesa, Double> colValor;
    @FXML private TableColumn<Despesa, LocalDate> colData;
    @FXML private TableColumn<Despesa, Categoria> colCategoria;

    @FXML private Label totalLabel;

    private DespesaDAO dao = new DespesaDAO();

    @FXML
    public void initialize() {
        // Configura as colunas da tabela para lerem os atributos da classe Despesa
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        colValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
        colData.setCellValueFactory(new PropertyValueFactory<>("data"));
        colCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));

        // Preenche o ComboBox com as opções do Enum
        categoriaBox.setItems(FXCollections.observableArrayList(Categoria.values()));

        atualizarTabela();
    }

    @FXML
    public void onAdicionar() {
        try {
            Despesa d = new Despesa();
            d.setDescricao(descricaoField.getText());
            d.setValor(Double.parseDouble(valorField.getText()));
            d.setData(dataPicker.getValue());
            d.setCategoria(categoriaBox.getValue());

            dao.salvar(d);
            atualizarTabela();
            limparCampos();
        } catch (Exception e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }
    }

    @FXML
    public void onExcluir() {
        Despesa selecionada = table.getSelectionModel().getSelectedItem();
        if (selecionada != null) {
            dao.excluir(selecionada.getId());
            atualizarTabela();
        }
    }

    @FXML
    public void onLimpar() {
        limparCampos();
    }

    @FXML
    public void onAtualizar() {
        // Lógica similar ao adicionar, mas mantendo o ID da despesa selecionada
        Despesa selecionada = table.getSelectionModel().getSelectedItem();
        if (selecionada != null) {
            selecionada.setDescricao(descricaoField.getText());
            selecionada.setValor(Double.parseDouble(valorField.getText()));
            selecionada.setData(dataPicker.getValue());
            selecionada.setCategoria(categoriaBox.getValue());

            dao.atualizar(selecionada);
            atualizarTabela();
            limparCampos();
        }
    }

    private void atualizarTabela() {
        List<Despesa> lista = dao.listar();
        table.setItems(FXCollections.observableArrayList(lista));

        // Atualiza o total
        double total = dao.total();
        totalLabel.setText(String.format("R$ %.2f", total));
    }

    private void limparCampos() {
        descricaoField.clear();
        valorField.clear();
        dataPicker.setValue(null);
        categoriaBox.setValue(null);
    }
}