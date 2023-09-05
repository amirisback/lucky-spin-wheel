package com.frogobox.spinwheel

import android.animation.Animator
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Matrix
import android.graphics.Paint
import android.graphics.Path
import android.graphics.Rect
import android.graphics.RectF
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.animation.DecelerateInterpolator
import kotlin.math.cos
import kotlin.math.min
import kotlin.math.sin

/**
 * Created by mohamed on 22/04/17.
 */
class WheelView : View {

    private var range = RectF()
    private var archPaint: Paint? = null
    private var textPaint: Paint? = null
    private var padding = 0
    private var radius = 0
    private var center = 0
    private var wheelBackground = 0
    private var imagePadding = 0
    private var mOnLuckyWheelReachTheTarget: OnLuckyWheelReachTheTarget? = null
    private var onRotationListener: OnRotationListener? = null

    val wheelItems = mutableListOf<WheelItem>()

    companion object {
        const val DEFAULT_PADDING = 5
        const val DEFAULT_ROTATION_TIME = 9000
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    private fun initComponents() {
        // arc paint object
        archPaint = Paint().apply {
            isAntiAlias = true
           isDither = true}

        // text paint object
        textPaint = Paint().apply {
            color = Color.WHITE
            isAntiAlias = true
            isDither = true
            textSize = 30f
        }

        // rect rang of the arc
        range = RectF(
            padding.toFloat(),
            padding.toFloat(),
            (padding + radius).toFloat(),
            (padding + radius).toFloat()
        )
    }

    /**
     * Get the angele of the target
     *
     * @return Number of angle
     */
    private fun getAngleOfIndexTarget(target: Int): Float {
        return (360 / wheelItems.size * target).toFloat()
    }

    /**
     * Function to set wheel background
     *
     * @param wheelBackground Wheel background color
     */
    fun setWheelBackgroundWheel(wheelBackground: Int) {
        this.wheelBackground = wheelBackground
        invalidate()
    }

    fun setItemsImagePadding(imagePadding: Int) {
        this.imagePadding = imagePadding
        invalidate()
    }

    /**
     * Function to set wheel listener
     *
     * @param onLuckyWheelReachTheTarget target reach listener
     */
    fun setWheelListener(onLuckyWheelReachTheTarget: OnLuckyWheelReachTheTarget?) {
        mOnLuckyWheelReachTheTarget = onLuckyWheelReachTheTarget
    }

    /**
     * Function to add wheels items
     *
     * @param wheelItems Wheels model item
     */
    fun addWheelItems(wheelItems: List<WheelItem>) {
        this.wheelItems.clear()
        this.wheelItems.addAll(wheelItems)
    }

    /**
     * Function to draw wheel background
     *
     * @param canvas Canvas of draw
     */
    private fun drawWheelBackground(canvas: Canvas) {
        val backgroundPainter = Paint()
        backgroundPainter.isAntiAlias = true
        backgroundPainter.isDither = true
        backgroundPainter.color = wheelBackground
        canvas.drawCircle(center.toFloat(), center.toFloat(), center.toFloat(), backgroundPainter)
    }

    /**
     * Function to draw image in the center of arc
     *
     * @param canvas    Canvas to draw
     * @param tempAngle Temporary angle
     * @param bitmap    Bitmap to draw
     */
    private fun drawImage(canvas: Canvas, tempAngle: Float, bitmap: Bitmap) {
        // get every arc img width and angle
        val imgWidth = radius / wheelItems.size - imagePadding
        val angle = ((tempAngle + 360 / wheelItems.size / 2) * Math.PI / 180).toFloat()
        // calculate x and y
        val x = (center + radius / 2 / 2 * cos(angle.toDouble())).toInt()
        val y = (center + radius / 2 / 2 * sin(angle.toDouble())).toInt()
        // create arc to draw
        val rect = Rect(x - imgWidth / 2, y - imgWidth / 2, x + imgWidth / 2, y + imgWidth / 2)
        // rotate main bitmap
        val px = rect.exactCenterX()
        val py = rect.exactCenterY()
        val matrix = Matrix()
        matrix.postTranslate((-bitmap.width / 2).toFloat(), (-bitmap.height / 2).toFloat())
        matrix.postRotate(tempAngle + 120)
        matrix.postTranslate(px, py)
        canvas.drawBitmap(
            bitmap,
            matrix,
            Paint(Paint.ANTI_ALIAS_FLAG or Paint.DITHER_FLAG or Paint.FILTER_BITMAP_FLAG)
        )
        Log.d("sadsdsddssd", bitmap.width.toString() + " : " + bitmap.height)
        matrix.reset()
    }

    /**
     * Function to draw text below image
     *
     * @param canvas     Canvas to draw
     * @param tempAngle  Temporary angle
     * @param sweepAngle current index angle
     * @param text       string to show
     */
    private fun drawText(canvas: Canvas, tempAngle: Float, sweepAngle: Float, text: String) {
        val path = Path()
        path.addArc(range, tempAngle, sweepAngle)
        val textWidth = textPaint!!.measureText(text)
        val hOffset = (radius * Math.PI / wheelItems.size / 2 - textWidth / 2).toInt()
        val vOffset = radius / 2 / 3 - 3
        canvas.drawTextOnPath(text, path, hOffset.toFloat(), vOffset.toFloat(), textPaint!!)
    }

    /**
     * Function to rotate wheel to target
     *
     * @param target target number
     */
    fun rotateWheelToTarget(target: Int) {

        val wheelItemCenter = 270 - getAngleOfIndexTarget(target) + 360 / wheelItems.size / 2

        animate().setInterpolator(DecelerateInterpolator())
            .setDuration(DEFAULT_ROTATION_TIME.toLong())
            .rotation(360 * 15 + wheelItemCenter)
            .setListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animation: Animator) {}
                override fun onAnimationEnd(animation: Animator) {
                    if (mOnLuckyWheelReachTheTarget != null) {
                        if (wheelItems[target-1].value.isNullOrEmpty()) {
                            val message = "Please Define Value On Wheel Item"
                            mOnLuckyWheelReachTheTarget!!.onReachTarget(message)
                        } else {
                            mOnLuckyWheelReachTheTarget!!.onReachTarget(wheelItems[target-1].value)
                        }
                    }
                    if (onRotationListener != null) {
                        onRotationListener!!.onFinishRotation()
                    }
                    clearAnimation()
                }

                override fun onAnimationCancel(animation: Animator) {}
                override fun onAnimationRepeat(animation: Animator) {}
            })
            .start()
    }

    /**
     * Function to rotate to zero angle
     *
     * @param target target to reach
     */
    fun resetRotationLocationToZeroAngle(target: Int) {
        animate().setDuration(0).rotation(0f).setListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animation: Animator) {}
                override fun onAnimationEnd(animation: Animator) {
                    rotateWheelToTarget(target)
                    clearAnimation()
                }

                override fun onAnimationCancel(animation: Animator) {}
                override fun onAnimationRepeat(animation: Animator) {}
            })
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        drawWheelBackground(canvas)
        initComponents()

        var tempAngle = 0f
        val sweepAngle = (360 / wheelItems.size).toFloat()

        for (i in wheelItems.indices) {
            archPaint!!.color = wheelItems[i].color
            canvas.drawArc(range, tempAngle, sweepAngle, true, archPaint!!)
            drawImage(canvas, tempAngle, wheelItems[i].image)
            drawText(canvas, tempAngle, sweepAngle, (if (wheelItems[i].text == null) "" else wheelItems[i].text)!!)
            tempAngle += sweepAngle
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val width = min(measuredWidth, measuredHeight)
        padding = if (paddingLeft == 0) DEFAULT_PADDING else paddingLeft
        radius = width - padding * 2
        center = width / 2
        setMeasuredDimension(width, width)
    }

    fun setOnRotationListener(onRotationListener: OnRotationListener?) {
        this.onRotationListener = onRotationListener
    }
}