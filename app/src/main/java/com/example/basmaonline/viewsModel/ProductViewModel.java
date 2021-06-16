package com.example.basmaonline.viewsModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.basmaonline.models.Product;
import com.example.basmaonline.repository.ProductRepository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductViewModel extends ViewModel {

        private MutableLiveData<List<Product>> products;
        private MutableLiveData<String> errMess;
       private ProductRepository productRepository;

       public ProductViewModel() {
            this.productRepository = new ProductRepository();
           if (products == null) {
               products = new MutableLiveData<>();
               //System.out.println("the size is " + products.getValue().size());
               loadProducts();
           }

//           return products;
        }
//        public LiveData<List<Product>> getProducts() {
//
//        }


        public MutableLiveData<List<Product>> getProductsMutableData() {
            return products;
        }



        private void loadProducts() {
            // Do an asynchronous operation to fetch produsts.
            Call<List<Product>> productsCall = productRepository.getAllProducts();
            productsCall.enqueue(new Callback<List<Product>>() {
                @Override
                public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                    if (errMess != null ) {
                        errMess.setValue("");
                    }
                    products.setValue(response.body());
//                    System.out.println("**************************** here and there \n ");
//                    System.out.println(products.getValue().size());
//                    System.out.println("end here is the end of the list ");
//                    System.out.println(response.body().size());
                }

                @Override
                public void onFailure(Call<List<Product>> call, Throwable t) {
                    //System.out.println("some error occur while loading data");
                    //System.out.println(t);
                    errMess = new MutableLiveData<>();
                    errMess.setValue("error while loading data");
                }
            });
        }
}

