package com.tt.projectshowcase.ui.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @author tturcic
 *         \date 30.8.2017.
 */
public abstract class BasePresenter<T extends BaseView> {

    protected T view;
    private CompositeDisposable rXsubscriptions;

    protected void addSubscription(Disposable d){
        if(rXsubscriptions == null){
            rXsubscriptions = new CompositeDisposable();
        }
        rXsubscriptions.add(d);
    }

    public void bind(T view){
        this.view = view;
    }

    public void unbind(){
        if(rXsubscriptions != null){
            rXsubscriptions.clear();
        }
    }
}
