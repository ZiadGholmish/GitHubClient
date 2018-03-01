package com.scalablecapitaltask.app

/**
 * Created by ziadgholmish on 2/26/18.
 */
abstract class AbsPresenter<V> {

    var mView: V? = null

    /**
     * attach the view to the presenter
     *
     * @param view activity or fragment to attach it to the presenter
     */
    fun attachView(view: V) {
        this.mView = view
    }

    /**
     * remove the view from the presenter
     */
    fun deAttachView() {
        this.mView = null
    }

    /**
     * check if the view is attached or not to the presenter
     */
    fun isAttached(): Boolean {
        return mView == null
    }


    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onResume() method.
     */
    abstract fun resume()

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onPause() method.
     */
    abstract fun pause()

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onDestroy() method.
     */
    abstract fun destroy()

}