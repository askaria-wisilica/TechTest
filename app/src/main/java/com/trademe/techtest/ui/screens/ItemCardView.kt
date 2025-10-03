package com.trademe.techtest.ui.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.trademe.techtest.model.ItemDetails
import com.trademe.techtest.R
import com.trademe.techtest.ui.theme.TextDark
import com.trademe.techtest.ui.theme.TextLight
import com.trademe.techtest.ui.theme.Typography

@Composable
fun ItemCardView(itemDetails: ItemDetails) {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp).background(color = Color.White),
        shape = RectangleShape, onClick = {
            Toast.makeText(context, itemDetails.name, Toast.LENGTH_SHORT).show()

        }
    ) {

        Row(
            modifier = Modifier.fillMaxWidth().background(color = Color.White),
            verticalAlignment = Alignment.CenterVertically
        ) {

            AsyncImage(
                model = itemDetails.imageUrl,
                contentDescription = "Item Icon",
                modifier = Modifier.size(80.dp),
                contentScale = androidx.compose.ui.layout.ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(8.dp))
            Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.Center) {
                Text(
                    text = itemDetails.location,
                    style = Typography.labelSmall.copy(color = TextLight)
                )
                Text(
                    text = itemDetails.name,
                    style = Typography.labelMedium.copy(color = TextDark),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(6.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth().padding(top = 10.dp)
                ) {
                    if (itemDetails.isClassified) {
                        Column {
                            Text(
                                text = "$${itemDetails.price}",
                                style = Typography.labelMedium.copy(
                                    color = TextDark,
                                    fontWeight = FontWeight.Bold
                                ),
                            )
                            Text(
                                text = stringResource(R.string.no_reserve),
                                style = Typography.labelSmall.copy(color = TextLight)
                            )
                        }
                    }else{
                        Spacer(modifier = Modifier.width(40.dp))
                    }
                    Column {
                        var price: Double? = itemDetails.price
                        if (null != itemDetails.buyNowPrice) {
                            price = itemDetails.buyNowPrice
                        }
                        Text(
                            text = "$${price}",
                            style = Typography.labelMedium.copy(
                                color = TextDark,
                                fontWeight = FontWeight.Bold
                            ),
                        )
                        Text(
                            text = stringResource(R.string.buy),
                            style = Typography.labelSmall.copy(color = TextLight)
                        )

                    }
                }

            }
        }
    }
}