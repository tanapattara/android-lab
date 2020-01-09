/*
 * Copyright (c) 2019 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.raywenderlich.galacticon

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recyclerview_item_row.view.*

class RecyclerAdapter(private val photos: ArrayList<Photo>) : RecyclerView.Adapter<RecyclerAdapter.PhotoHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.PhotoHolder {
    val inflatedView = parent.inflate(R.layout.recyclerview_item_row, false)
    return PhotoHolder(inflatedView)
  }

  override fun getItemCount(): Int = photos.size

  override fun onBindViewHolder(holder: RecyclerAdapter.PhotoHolder, position: Int) {
    val itemPhoto = photos[position]
    holder.bindPhoto(itemPhoto)
  }

  //1
  class PhotoHolder(private val view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
    //2
    private var photo: Photo? = null

    //3
    init {
      view.setOnClickListener(this)
    }

    fun bindPhoto(photo: Photo) {
      this.photo = photo
      Picasso.with(view.context).load(photo.url).into(view.itemImage)
      view.itemDate.text = photo.humanDate
      view.itemDescription.text = photo.explanation
    }

    //4
    override fun onClick(v: View) {
      val context = itemView.context
      val showPhotoIntent = Intent(context, PhotoActivity::class.java)
      showPhotoIntent.putExtra(PHOTO_KEY, photo)
      context.startActivity(showPhotoIntent)
      Log.d("RecyclerView", "CLICK!")
    }

    companion object {
      //5
      private val PHOTO_KEY = "PHOTO"
    }
  }

}