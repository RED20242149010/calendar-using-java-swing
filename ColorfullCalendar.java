import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class ColorfullCalendar extends JFrame {

    private static final Color[] RAINBOW = {
            new Color(255,80,80),
            new Color(255,160,0),
            new Color(220,200,0),
            new Color(50,180,50),
            new Color(30,144,255),
            new Color(120,80,200),
            new Color(200,0,200)
    };

    private Map<String,String> events = new HashMap<>();
    private Map<String,String> specialEvents = new HashMap<>();

    private JTextField yearField, monthField;

    private int currentYear;
    private int currentMonth;

    public ColorfullCalendar() {
        super("🌈 Colorfull Calendar");
        loadSpecialEvents();
        setSize(520, 340);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        showInputScreen();
        setVisible(true);
    }

    private void loadSpecialEvents() {
        specialEvents.put("01-01", "🎉 New Year's Day");
        specialEvents.put("01-04", "World Braille Day");
        specialEvents.put("01-24", "📚 International Day of Education");
        specialEvents.put("01-26", "International Customs Day");

        specialEvents.put("02-04", "World Cancer Day");
        specialEvents.put("02-11", "🔬 International Day of Women and Girls in Science");
        specialEvents.put("02-14", "❤️ Valentine's Day");
        specialEvents.put("02-17", "🎂 Rafi's Birthday");
        specialEvents.put("02-20", "World Day of Social Justice");
        specialEvents.put("02-21", "🌍 International Mother Language Day");

        specialEvents.put("03-03", "🐾 World Wildlife Day");
        specialEvents.put("03-08", "👩 International Women's Day");
        specialEvents.put("03-20", "😊 International Day of Happiness");
        specialEvents.put("03-22", "💧 World Water Day");
        specialEvents.put("03-23", "World Meteorological Day");

        specialEvents.put("04-01", "😄 April Fools' Day");
        specialEvents.put("04-07", "🏥 World Health Day");
        specialEvents.put("04-10", "🎂 Oyshikee's Birthday");
        specialEvents.put("04-12", "🚀 International Day of Human Space Flight");
        specialEvents.put("04-15", "🎨 World Art Day");
        specialEvents.put("04-22", "🌎 Earth Day");

        specialEvents.put("05-01", "International Workers' Day");
        specialEvents.put("05-03", "📰 World Press Freedom Day");
        specialEvents.put("05-12", "International Nurses Day");
        specialEvents.put("05-15", "🎂 Fatema's Birthday");
        specialEvents.put("05-31", "🚭 World No Tobacco Day");

        specialEvents.put("06-05", "🌱 World Environment Day");
        specialEvents.put("06-08", "🌊 World Oceans Day");
        specialEvents.put("06-12", "World Day Against Child Labour");
        specialEvents.put("06-21", "🧘 International Yoga Day");
        specialEvents.put("06-26", "International Day Against Drug Abuse");

        specialEvents.put("07-01", "😆 International Joke Day");
        specialEvents.put("07-11", "World Population Day");
        specialEvents.put("07-18", "Nelson Mandela International Day");
        specialEvents.put("07-28", "World Nature Conservation Day");

        specialEvents.put("08-12", "👩‍🎓 International Youth Day");
        specialEvents.put("08-19", "World Humanitarian Day");
        specialEvents.put("08-29", "International Day Against Nuclear Tests");

        specialEvents.put("09-08", "📖 International Literacy Day");
        specialEvents.put("09-10", "World Suicide Prevention Day");
        specialEvents.put("09-21", "☮️ International Day of Peace");
        specialEvents.put("09-27", "✈️ World Tourism Day");

        specialEvents.put("10-01", "International Day of Older Persons");
        specialEvents.put("10-05", "🍎 World Teachers' Day");
        specialEvents.put("10-10", "🎂 Oyshee's Birthday");
        specialEvents.put("10-24", "United Nations Day");
        specialEvents.put("10-31", "🎂 Tisha's Birthday");

        specialEvents.put("11-11", "🎂 Ovi's Birthday");
        specialEvents.put("11-14", "World Diabetes Day");
        specialEvents.put("11-16", "International Day for Tolerance");
        specialEvents.put("11-20", "👶 Universal Children's Day");
        specialEvents.put("11-25", "International Day for the Elimination of Violence Against Women");
        specialEvents.put("11-29", "🎂 Kallyan's Birthday");

        specialEvents.put("12-01", "World AIDS Day");
        specialEvents.put("12-10", "Human Rights Day");
        specialEvents.put("12-25", "🎄 Christmas Day");
        specialEvents.put("12-31", "🎆 New Year's Eve");
    }

    private void showAboutWindow() {
        JFrame about = new JFrame("About — Colorfull Calendar");
        about.setSize(480, 480);
        about.setLocationRelativeTo(this);
        about.setResizable(false);

        JPanel root = new JPanel(new BorderLayout());
        root.setBackground(new Color(25, 25, 60));

        JPanel banner = new JPanel(new BorderLayout());
        banner.setBackground(new Color(40, 40, 90));
        banner.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel appName = new JLabel("Colorfull Calendar", SwingConstants.CENTER);
        appName.setFont(new Font("Segoe UI", Font.BOLD, 24));
        appName.setForeground(new Color(255, 220, 120));

        JLabel version = new JLabel("Version 1.0", SwingConstants.CENTER);
        version.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        version.setForeground(new Color(180, 180, 220));

        JPanel bannerText = new JPanel();
        bannerText.setLayout(new BoxLayout(bannerText, BoxLayout.Y_AXIS));
        bannerText.setOpaque(false);
        appName.setAlignmentX(Component.CENTER_ALIGNMENT);
        version.setAlignmentX(Component.CENTER_ALIGNMENT);
        bannerText.add(appName);
        bannerText.add(Box.createVerticalStrut(4));
        bannerText.add(version);

        banner.add(bannerText, BorderLayout.CENTER);

        JPanel info = new JPanel();
        info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));
        info.setBackground(new Color(25, 25, 60));
        info.setBorder(BorderFactory.createEmptyBorder(18, 28, 10, 28));

        info.add(makeCard("👨‍💻  Developer", "MD. Sanzidul Islam Reshad",  new Color(60, 120, 220)));
        info.add(Box.createVerticalStrut(10));
        info.add(makeCard("🪪  Student ID", "20242149010",                 new Color(50, 160, 100)));
        info.add(Box.createVerticalStrut(10));
        info.add(makeCard("📘  Course",     "CSE-2200",                    new Color(180, 70, 200)));
        info.add(Box.createVerticalStrut(10));
        info.add(makeCard("📋  Description",
                "<html>This project is developed by<br>" +
                "MD. Sanzidul Islam Reshad<br>" +
                "ID: 20242149010 &nbsp;|&nbsp; Under CSE-2200</html>",
                new Color(200, 120, 30)));

        JPanel bottom = new JPanel();
        bottom.setBackground(new Color(25, 25, 60));
        bottom.setBorder(BorderFactory.createEmptyBorder(6, 0, 16, 0));

        JButton close = new JButton("✖  Close");
        close.setBackground(new Color(200, 50, 50));
        close.setForeground(Color.WHITE);
        close.setFont(new Font("Segoe UI", Font.BOLD, 13));
        close.setFocusPainted(false);
        close.setPreferredSize(new Dimension(120, 34));
        close.addActionListener(e -> about.dispose());

        bottom.add(close);

        root.add(banner, BorderLayout.NORTH);
        root.add(info,   BorderLayout.CENTER);
        root.add(bottom, BorderLayout.SOUTH);

        about.add(root);
        about.setVisible(true);
    }

    private JPanel makeCard(String label, String value, Color accent) {
        JPanel card = new JPanel(new BorderLayout(10, 0));
        card.setBackground(new Color(40, 40, 80));
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 4, 0, 0, accent),
                BorderFactory.createEmptyBorder(10, 14, 10, 14)
        ));
        card.setMaximumSize(new Dimension(Integer.MAX_VALUE, 90));

        JLabel lbl = new JLabel(label);
        lbl.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lbl.setForeground(accent);

        JLabel val = new JLabel(value);
        val.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        val.setForeground(Color.WHITE);

        JPanel texts = new JPanel();
        texts.setLayout(new BoxLayout(texts, BoxLayout.Y_AXIS));
        texts.setOpaque(false);
        texts.add(lbl);
        texts.add(Box.createVerticalStrut(3));
        texts.add(val);

        card.add(texts, BorderLayout.CENTER);
        return card;
    }

    private void showInputScreen() {
        getContentPane().removeAll();

        JPanel root = new JPanel(new BorderLayout(20, 20));
        root.setBackground(new Color(40, 40, 90));
        root.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        JLabel title = new JLabel("🌈 Colorfull Calendar", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 30));
        title.setForeground(new Color(255, 220, 120));

        root.add(title, BorderLayout.NORTH);

        JPanel form = new JPanel(new GridBagLayout());
        form.setOpaque(false);

        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(10, 10, 10, 10);

        JLabel yearLabel = new JLabel("Enter Year:");
        yearLabel.setForeground(Color.WHITE);

        JLabel monthLabel = new JLabel("Enter Month:");
        monthLabel.setForeground(Color.WHITE);

        yearField = new JTextField("2025");
        yearField.setPreferredSize(new Dimension(80, 28));

        monthField = new JTextField("1");
        monthField.setPreferredSize(new Dimension(80, 28));

        g.gridx = 0; g.gridy = 0;
        form.add(yearLabel, g);

        g.gridx = 1;
        form.add(yearField, g);

        g.gridx = 0; g.gridy = 1;
        form.add(monthLabel, g);

        g.gridx = 1;
        form.add(monthField, g);

        root.add(form, BorderLayout.CENTER);

        JPanel buttons = new JPanel();
        buttons.setOpaque(false);

        JButton showMonth = new JButton("📅 Show Month");
        showMonth.setBackground(new Color(60, 140, 255));
        showMonth.setForeground(Color.WHITE);

        JButton showYear = new JButton("🗓 Full Year");
        showYear.setBackground(new Color(60, 200, 120));
        showYear.setForeground(Color.WHITE);

        JButton aboutBtn = new JButton("ℹ About");
        aboutBtn.setBackground(new Color(180, 60, 200));
        aboutBtn.setForeground(Color.WHITE);

        showMonth.addActionListener(e -> handleMonthView());
        showYear.addActionListener(e -> handleFullYear());
        aboutBtn.addActionListener(e -> showAboutWindow());

        buttons.add(showMonth);
        buttons.add(showYear);
        buttons.add(aboutBtn);

        root.add(buttons, BorderLayout.SOUTH);

        add(root);
        revalidate();
        repaint();
    }

    private void handleMonthView() {
        int year  = Integer.parseInt(yearField.getText());
        int month = Integer.parseInt(monthField.getText());
        currentYear  = year;
        currentMonth = month;
        showMonthScreen(year, month);
    }

    private void handleFullYear() {
        int year = Integer.parseInt(yearField.getText());
        showFullYearScreen(year);
    }

    private void showMonthScreen(int year, int month) {
        String leap = isLeapYear(year) ? " 🍀 Leap Year!" : "";

        JFrame frame = new JFrame(monthName(month) + " " + year + leap);
        frame.setSize(720, 520);

        JPanel root = new JPanel(new BorderLayout());

        JLabel header = new JLabel(monthName(month) + " " + year + leap, SwingConstants.CENTER);
        header.setFont(new Font("Segoe UI", Font.BOLD, 22));

        root.add(header, BorderLayout.NORTH);
        root.add(buildMonthPanel(year, month), BorderLayout.CENTER);

        JButton prev = new JButton("◀ Previous");
        JButton next = new JButton("Next ▶");

        prev.addActionListener(e -> {
            currentMonth--;
            if (currentMonth < 1) { currentMonth = 12; currentYear--; }
            frame.dispose();
            showMonthScreen(currentYear, currentMonth);
        });

        next.addActionListener(e -> {
            currentMonth++;
            if (currentMonth > 12) { currentMonth = 1; currentYear++; }
            frame.dispose();
            showMonthScreen(currentYear, currentMonth);
        });

        JPanel nav = new JPanel();
        nav.add(prev);
        nav.add(next);

        root.add(nav, BorderLayout.SOUTH);

        frame.add(root);
        frame.setLocationRelativeTo(this);
        frame.setVisible(true);
    }

    private void showFullYearScreen(int year) {
        JFrame frame = new JFrame("Year " + year);
        frame.setSize(1100, 720);

        JPanel grid = new JPanel(new GridLayout(3, 4, 10, 10));

        for (int m = 1; m <= 12; m++)
            grid.add(buildMonthPanel(year, m));

        frame.add(new JScrollPane(grid));
        frame.setLocationRelativeTo(this);
        frame.setVisible(true);
    }

    private JPanel buildMonthPanel(int year, int month) {
        JPanel panel = new JPanel(new BorderLayout());

        JLabel title = new JLabel(monthName(month), SwingConstants.CENTER);
        panel.add(title, BorderLayout.NORTH);

        JPanel grid = new JPanel(new GridLayout(0, 7));

        String[] days = {"Su","Mo","Tu","We","Th","Fr","Sa"};

        for (int i = 0; i < 7; i++) {
            JLabel d = new JLabel(days[i], SwingConstants.CENTER);
            d.setForeground(RAINBOW[i]);
            grid.add(d);
        }

        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, 1);

        int start       = cal.get(Calendar.DAY_OF_WEEK) - 1;
        int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        for (int i = 0; i < start; i++)
            grid.add(new JLabel(""));

        for (int d = 1; d <= daysInMonth; d++) {
            int dow = (start + d - 1) % 7;

            String eventKey = String.format("%02d-%02d", month, d);
            String userKey  = String.format("%04d-%02d-%02d", year, month, d);

            JPanel cell = new JPanel();
            cell.setLayout(new BoxLayout(cell, BoxLayout.Y_AXIS));
            cell.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

            JLabel dayLabel = new JLabel("" + d);
            dayLabel.setForeground(RAINBOW[dow]);
            dayLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            cell.add(dayLabel);

            if (specialEvents.containsKey(eventKey)) {
                JLabel ev = new JLabel(specialEvents.get(eventKey));
                ev.setFont(new Font("Segoe UI", Font.PLAIN, 10));
                ev.setAlignmentX(Component.CENTER_ALIGNMENT);
                cell.add(ev);
                cell.setBackground(new Color(255, 240, 180));
                cell.setToolTipText(specialEvents.get(eventKey));
            }

            if (events.containsKey(userKey)) {
                JLabel ev = new JLabel(events.get(userKey));
                ev.setFont(new Font("Segoe UI", Font.PLAIN, 10));
                ev.setAlignmentX(Component.CENTER_ALIGNMENT);
                cell.add(ev);
                cell.setBackground(Color.YELLOW);
                cell.setToolTipText(events.get(userKey));
            }

            cell.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    String event = JOptionPane.showInputDialog("Add Event:");
                    if (event != null && !event.trim().isEmpty()) {
                        events.put(userKey, event);
                        JOptionPane.showMessageDialog(null, "Event Added");
                    }
                }
            });

            grid.add(cell);
        }

        panel.add(grid, BorderLayout.CENTER);
        return panel;
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    private String monthName(int m) {
        String[] months = {"January","February","March","April","May","June",
                           "July","August","September","October","November","December"};
        return months[m - 1];
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ColorfullCalendar());
    }
}