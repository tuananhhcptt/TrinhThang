package clone.vtpay.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import com.google.android.material.bottomnavigation.BottomNavigationView

class CustomBottomNavigation(context: Context, attrs: AttributeSet?) :
    BottomNavigationView(context, attrs) {

    private var mPath: Path = Path()
    private var mPaint : Paint = Paint()
    private var mNavigationBarWidth = 0;
    private var mNavigationBarHeight = 0;

    // The radius of fab button
    val CURVE_CIRCLE_RADIUS = 90

    // The coordinates of the first curve
    private var mFirstCurveStartPoint: Point = Point()
    private var mFirstCurveEndPoint: Point = Point()
    private var mFirstCurveControlPoint1: Point = Point()
    private var mFirstCurveControlPoint2: Point = Point()

    //The coordinates of the second curve
    private var mSecondCurveStartPoint: Point = Point()
    private var mSecondCurveEndPoint: Point = Point()
    private var mSecondCurveControlPoint1: Point = Point()
    private var mSecondCurveControlPoint2: Point = Point()


    init {
        mPaint.style = Paint.Style.FILL_AND_STROKE;
        mPaint.color = Color.WHITE;
        setBackgroundColor(Color.TRANSPARENT);
    }



    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
//        super.onSizeChanged(w, h, oldw, oldh)

        mNavigationBarWidth = width
        mNavigationBarHeight = height

        mFirstCurveStartPoint.set((mNavigationBarWidth / 2) - (CURVE_CIRCLE_RADIUS * 2) - (CURVE_CIRCLE_RADIUS / 3), 0);
        // the coordinates (x,y) of the end point after curve
        mFirstCurveEndPoint.set(mNavigationBarWidth / 2, CURVE_CIRCLE_RADIUS + (CURVE_CIRCLE_RADIUS / 4));
        // same thing for the second curve
        mSecondCurveStartPoint = mFirstCurveEndPoint;
        mSecondCurveEndPoint.set((mNavigationBarWidth / 2) + (CURVE_CIRCLE_RADIUS * 2) + (CURVE_CIRCLE_RADIUS / 3), 0);

        // the coordinates (x,y)  of the 1st control point on a cubic curve
        mFirstCurveControlPoint1.set(mFirstCurveStartPoint.x + CURVE_CIRCLE_RADIUS + (CURVE_CIRCLE_RADIUS / 4), mFirstCurveStartPoint.y);
        // the coordinates (x,y)  of the 2nd control point on a cubic curve
        mFirstCurveControlPoint2.set(mFirstCurveEndPoint.x - (CURVE_CIRCLE_RADIUS * 2) + CURVE_CIRCLE_RADIUS, mFirstCurveEndPoint.y);

        mSecondCurveControlPoint1.set(mSecondCurveStartPoint.x + (CURVE_CIRCLE_RADIUS * 2) - CURVE_CIRCLE_RADIUS, mSecondCurveStartPoint.y);
        mSecondCurveControlPoint2.set(mSecondCurveEndPoint.x - (CURVE_CIRCLE_RADIUS + (CURVE_CIRCLE_RADIUS / 4)), mSecondCurveEndPoint.y);

        mPath.reset();
        mPath.moveTo(0f, 0f);
        mPath.lineTo(mFirstCurveStartPoint.x.toFloat(), mFirstCurveStartPoint.y.toFloat());

        mPath.cubicTo(mFirstCurveControlPoint1.x.toFloat(), mFirstCurveControlPoint1.y.toFloat(),
            mFirstCurveControlPoint2.x.toFloat(), mFirstCurveControlPoint2.y.toFloat(),
            mFirstCurveEndPoint.x.toFloat(), mFirstCurveEndPoint.y.toFloat());

        mPath.cubicTo(mSecondCurveControlPoint1.x.toFloat(), mSecondCurveControlPoint1.y.toFloat(),
            mSecondCurveControlPoint2.x.toFloat(), mSecondCurveControlPoint2.y.toFloat(),
            mSecondCurveEndPoint.x.toFloat(), mSecondCurveEndPoint.y.toFloat());

        mPath.lineTo(mNavigationBarWidth.toFloat(), 0f);
        mPath.lineTo(mNavigationBarWidth.toFloat(), mNavigationBarHeight.toFloat());
        mPath.lineTo(0f, mNavigationBarHeight.toFloat());
        mPath.close();
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas!!.drawPath(mPath, mPaint);
    }
}