import {
    Drawer,
    List,
    ListItem,
    ListItemButton,
    ListItemText,
    Toolbar,
    Box
} from "@mui/material";

import { Link } from "react-router-dom";

const drawerWidth = 240;

function MainLayout({ children }) {
    return (
        <Box sx={{ display: "flex" }}>
            <Drawer
                variant="permanent"
                sx={{
                    width: drawerWidth,
                    "& .MuiDrawer-paper": {
                        width: drawerWidth
                    }
                }}
            >
                <Toolbar />

                <List>
                    <ListItem disablePadding>
                        <ListItemButton
                            component={Link}
                            to="/dashboard"
                        >
                            <ListItemText primary="Dashboard" />
                        </ListItemButton>
                    </ListItem>

                    <ListItem disablePadding>
                        <ListItemButton
                            component={Link}
                            to="/employees"
                        >
                            <ListItemText primary="Employees" />
                        </ListItemButton>
                    </ListItem>
                </List>
            </Drawer>

            <Box
                component="main"
                sx={{
                    flexGrow: 1,
                    p: 3
                }}
            >
                {children}
            </Box>
        </Box>
    );
}

export default MainLayout;