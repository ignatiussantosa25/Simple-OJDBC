/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;

/**
 *
 * @author Ignatius
 */
public interface ControllerInterface {
    public boolean insert(Object obj);
    public boolean delete(String id);
    public boolean update(Object obj);
    public List<Object> search(String kategori, String cari);
    public List<Object> getAll();
    public Object getBy(String id);
}
