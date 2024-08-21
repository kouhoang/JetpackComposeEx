package com.example.jetpackcomposeex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposeex.ui.theme.JetpackComposeExTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeExTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        TopSection()
                        TagsSection()
                        Spacer(modifier = Modifier.height(4.dp))
                        HorizontalDivider()
                        Spacer(modifier = Modifier.height(4.dp))
                        StatisticsSection()
                        Spacer(modifier = Modifier.height(4.dp))
                        HorizontalDivider()
                        Spacer(modifier = Modifier.height(4.dp))
                        RatingRow()
                        HorizontalDivider()
                        NevegateUI()
                        HorizontalDivider()
                        OrderListScreen()
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun TopSection() {
    Row(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                "<",
                style = MaterialTheme.typography.headlineSmall,
                color = Color(0xFF4CAF50),
            )

            Spacer(modifier = Modifier.width(8.dp))

            Box(
                modifier =
                    Modifier
                        .size(50.dp)
                        .background(Color(0xFF4CAF50), shape = CircleShape),
                contentAlignment = Alignment.Center,
            ) {
                Text("55", color = Color.White)
            }

            Spacer(modifier = Modifier.width(8.dp))

            Column(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .height(60.dp),
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f),
                ) {
                    Text(
                        "843***4455",
                        style = MaterialTheme.typography.headlineLarge,
                        fontSize = 16.sp,
                        modifier = Modifier.weight(1f),
                    )

                    Button(
                        onClick = { /* TODO: Follow logic */ },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)),
                        shape = RectangleShape,
                        modifier =
                            Modifier
                                .height(24.dp)
                                .width(80.dp),
                        contentPadding = PaddingValues(0.dp),
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Favorite,
                                contentDescription = "Heart Icon",
                                tint = Color.White,
                                modifier = Modifier.size(12.dp),
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                "Theo dõi",
                                color = Color.White,
                                fontSize = 10.sp,
                                maxLines = 1,
                                overflow = TextOverflow.Clip,
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                Column(
                    modifier = Modifier.weight(1f),
                ) {
                    Text(
                        "✓ Đã xác thực SDT & Địa chỉ",
                        color = Color.Black,
                        fontSize = 14.sp,
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Preview
@Composable
fun TagsSection() {
    FlowRow(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(top = 4.dp, bottom = 4.dp, start = 16.dp, end = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        listOf(
            "Đã mua" to Color.White,
            "Thiết bị điện tử" to Color.LightGray,
            "Voucher" to Color.Yellow,
            "Thiết bị điện gia dụng" to Color.Cyan,
            "Mẹ và bé" to Color.Magenta,
            "Nhà cửa" to Color.Green,
        ).forEach { (tag, color) ->
            Text(
                text = tag,
                modifier =
                    Modifier
                        .clip(RoundedCornerShape(4.dp))
                        .background(color)
                        .padding(4.dp),
                fontSize = 16.sp,
            )
        }
    }
}

@Preview
@Composable
fun StatisticsSection() {
    Row(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
        // Đồng bộ padding với RatingRow
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        StatisticItem(label = "Độ cháy túi", value = "--")
        Spacer(modifier = Modifier.width(16.dp))
        StatisticItem(label = "ĐH đã đặt", value = "80")
        Spacer(modifier = Modifier.width(16.dp))
        StatisticItem(label = "Thành công", value = "--")
        Spacer(modifier = Modifier.width(16.dp))
        StatisticItem(label = "Tốc độ nhận", value = " \uD83D\uDE80 Tên lửa")
    }
}

@Composable
fun StatisticItem(
    label: String,
    value: String,
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(value, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.Black)
        Text(label, color = Color.Gray, fontSize = 14.sp)
    }
}

@Composable
fun HorizontalDivider(
    color: Color = Color.Gray,
    thickness: Dp = 1.dp,
    modifier: Modifier = Modifier,
) {
    Divider(
        color = color,
        thickness = thickness,
        modifier =
            modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
    )
}

@Preview
@Composable
fun RatingRow() {
    Row(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        RatingItem(count = "38", emoji = "😍", label = "Đánh giá")
        Spacer(modifier = Modifier.width(16.dp))
        RatingItem(count = "10", emoji = "😡", label = "Đã ghé thăm")
        Spacer(modifier = Modifier.width(16.dp))
        RatingItem(count = "10 Shop", label = "Đã mua")
        Spacer(modifier = Modifier.width(16.dp))
        RatingItem(count = "11 Shop", label = "Chu kỳ mua")
    }
}

@Composable
fun RatingItem(
    count: String,
    emoji: String? = null,
    label: String,
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = count, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.Black)
            emoji?.let {
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = it, fontSize = 18.sp)
            }
        }
        Text(text = label, fontSize = 14.sp, color = Color.Gray)
    }
}

@Preview
@Composable
fun NevegateUI() {
    Row(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(
            modifier =
                Modifier
                    .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Hoạt động",
                color = Color(0xFF4CAF50),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            )
            Spacer(
                modifier =
                    Modifier
                        .height(2.dp)
                        .fillMaxWidth()
                        .background(Color(0xFF4CAF50)),
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "Nhận hàng",
            color = Color.Black,
            fontSize = 16.sp,
            modifier = Modifier.weight(1f),
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "2lanstore",
            color = Color.Black,
            fontSize = 16.sp,
            modifier = Modifier.weight(1f),
        )
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Preview
@Composable
fun OrderListScreen() {
    Row(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(top = 4.dp, bottom = 4.dp, start = 16.dp, end = 16.dp),
    ) {
        LazyColumn(
            modifier = Modifier.weight(1f),
        ) {
            items(orderItems.size) { index ->
                OrderItem(
                    text = orderItems[index].text,
                    date = orderItems[index].date,
                )
            }
        }

        Spacer(modifier = Modifier.width(8.dp))

        // Right Side Buttons
        Column(
            modifier =
                Modifier
                    .width(80.dp)
                    .background(Color(0xFF2E7D32), shape = RoundedCornerShape(8.dp)),
        ) {
            SideButton(iconRes = R.drawable.ic_call, label = "Gọi điện")
            SideButton(iconRes = R.drawable.ic_chat, label = "Chat")
            SideButton(iconRes = R.drawable.ic_add_order, label = "Tạo ĐH")
            SideButton(iconRes = R.drawable.ic_review, label = "Đánh giá")
        }
    }
}

@Composable
fun OrderItem(
    text: String,
    date: String,
) {
    Row(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(
            modifier = Modifier.weight(1f),
        ) {
            Text(text = text, fontWeight = FontWeight.Bold, fontSize = 14.sp)
        }

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = date,
            fontSize = 12.sp,
            color = Color.Gray,
            modifier = Modifier.width(80.dp),
        )
    }
}

@Composable
fun SideButton(
    iconRes: Int,
    label: String,
) {
    Column(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .clickable { /* Handle click */ },
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = label,
            modifier = Modifier.size(32.dp),
            tint = Color.White,
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = label, color = Color.White, fontSize = 12.sp)
    }
}

data class OrderItemData(
    val text: String,
    val date: String,
)

val orderItems =
    listOf(
        OrderItemData("YEAHHH! hai đã đặt hàng sản phẩm Giá trị cao", "10/10/2023"),
        OrderItemData("YEAHHH! hai đã đặt hàng sản phẩm Thực phẩm khô", "10/10/2023"),
        OrderItemData("YEAHHH!s hai đã đặt hàng sản phẩm Thực phẩm tươi", "10/10/2023"),
        OrderItemData("YEAHHH! phus đã đặt hàng sản phẩm 2023-09-20", "29/09/2023"),
        OrderItemData("YEAHHH! phus đã đặt hàng sản phẩm 2023-09-20, fsdf", "29/09/2023"),
        OrderItemData("YEAHHH! hai đã đặt hàng sản phẩm heli, 1", "29/09/2023"),
        OrderItemData("YEAHHH! phus đã đặt hàng sản phẩm 090", "12/09/2023"),
        OrderItemData("YEAHHH! phus đã đặt hàng sản phẩm 090", "12/09/2023"),
    )
